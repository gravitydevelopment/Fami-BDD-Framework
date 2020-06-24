
# BASE IMAGE
FROM maven:3.6.3-jdk-8

# CONFIGURE MAVEN PATH
ENV MAVEN_HOME /usr/share/java/maven-3
ENV PATH $PATH:$MAVEN_HOME/bin
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# SETUP CHROME
ARG CHROME_VERSION=83.0.4103.116-1
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
	&& echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
	&& apt-get update -qqy \
	&& apt-get -qqy install google-chrome-stable=$CHROME_VERSION \
	&& rm /etc/apt/sources.list.d/google-chrome.list \
	&& rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
	&& sed -i 's/"$HERE\/chrome"/"$HERE\/chrome" --no-sandbox/g' /opt/google/chrome/google-chrome
	
ARG CHROME_DRIVER_VERSION=83.0.4103.39
RUN wget -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
	&& unzip /tmp/chromedriver.zip -d /opt \
	&& rm /tmp/chromedriver.zip \
	&& mv /opt/chromedriver /opt/chromedriver-$CHROME_DRIVER_VERSION \
	&& chmod 755 /opt/chromedriver-$CHROME_DRIVER_VERSION \
	&& ln -s /opt/chromedriver-$CHROME_DRIVER_VERSION /usr/bin/chromedriver

COPY . .
RUN mvn clean install exec:java
RUN mvn cluecumber-report:reporting

FROM tomcat:8.0-alpine
LABEL maintainer="myTomcat"
COPY ./target/cluecumber-report /usr/local/tomcat/webapps/ROOT/
EXPOSE 8080
CMD ["catalina.sh", "run"]