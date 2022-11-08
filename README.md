<h1 align="center">
   <a href="#"> Kafka Fundamentals </a>
</h1>

<h3 align="center">
    A project to practice Kafka fundamentals
</h3>

<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/jh-ecomp/kafka-fundamentals-with-java?color=%2304D361">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/jh-ecomp/kafka-fundamentals-with-java">
  <a href="https://github.com/jh-ecomp/kafka-fundamentals-with-java/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/jh-ecomp/kafka-fundamentals-with-java">
  </a>
  <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
  <a href="https://docs.confluent.io/platform/current/clients/javadocs/javadoc/index.html#ak-java-apis">
    <img alt="Jira" src="https://img.shields.io/badge/Kafka-Java%20Clients%20APIs-0052cc">
  </a>
</p>

#### Status: Done
### Summary
• [About](#about)
• [How it works](#how-it-works)
• [Before Installation](#before-installation)
• [Maven Dependencies](#maven-dependencies)
• [Installation](#installation)
• [Using](#using)
• [Author](#author)
• [License](#user-content-license)

### About

Kafka Fundamentals is a Maven project that implements the basics of the Kafka Client APIs. Consumer and Producer services are separated into individual models, like the Kafka layer.

### How it works

This is a Maven project that implements Kafka Clients APIs. You must to have both of Kafka and Zookeeper running in your computer.

The consumer service modules, service-fraud-detector, service-email and/or service-log, will subscribe to the kafka topics specified in their classes and wait for massages.

The producer service module will send messages to two topics at the same time, ten at a time.

You will see the consumers receiving the messages, each from the topic they are subscribed to.

### Before Installation

Before you begin, you will need to have the following tools installed on your machine:
[Git] (https://git-scm.com), [Java 11+] (https://www.java.com), [Kafka] (https://kafka.apache.org).
As a suggestion, use a modern editor like [IntelliJ] (https://www.jetbrains.com/idea) or [VSCode ] (https://code.visualstudio.com)

### Maven Dependencies

```bash

# kafka-clients
# slf4j-simple
# gson

```

### Installation

```bash

# Clone this repository
$ git clone git@github.com:jh-ecomp/kafka-fundamentals-with-java.git  

# Access the project folder cmd/terminal  
$ cd kafka-fundamentals-with-java/ecommerce
```

### Using
##### This project contains the basic usage of Kafka Clients APIs

Make sure you have Kafka and Zookeeper running in your computer.

Inside the project you can run the consumer service modules:
- service-fraud-detector
- service-email
- service-log

After that run service-new-order, this is the producer (aka dispatcher) of messages. It will send messagens to Kafka topics.

For each consumer you can see it receiving the messages from the Kafka topic.

Try run two ot three instances of service-fraud-detector. This way you will be able to see the kafka broker spliting the messages between the consumers.

### Author

<a href="https://github.com/jh-ecomp?tab=repositories">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/21336271?s=400&u=4b4ff916cafb59709adaa958f3c0f46bed35ae62&v=4" width="100px;" alt="João Henrique"/>
 <br />
 <sub><b>João Henrique</b></sub></a> <a href="https://github.com/jh-ecomp?tab=repositories" title="João Henrique"></a>
 <br />
---

### License

This project is under the license [MIT](./LICENSE.txt).

Made by João Henrique 👋🏽 [Get in Touch!](Https://www.linkedin.com/in/joaohenriqueengcomp )
