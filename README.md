# open-translator
[![](https://jitpack.io/v/doomedcat17/open-translator.svg)](https://jitpack.io/#doomedcat17/open-translator)

*Free Google Translator library for Java.*

**This project is basically a re-write of [therealbush/translator](https://github.com/therealbush/translator) from Kotlin to Java 11.
If you don't need pure Java library, use therealbush's translator.**

## What is this?
Simple Java library that uses [Google Translate Ajax API](https://translate.google.com/) free translations. API token is not required.

I needed some translations of one of my personal projects and found [therealbush/translator](https://github.com/therealbush/translator).
It works fine, but I needed pure Java library to customize WebClient. 

## Installation
### Maven
Add [JitPack](https://jitpack.io/) to your project repos:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
And then add following dependency:
```xml
<dependency>
    <groupId>com.github.doomedcat17</groupId>
    <artifactId>open-translator</artifactId>
    <version>1.0.0</version>
</dependency>
```
### Gradle
Add [JitPack](https://jitpack.io/) to your project repos:
```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
And then add following dependency:
```gradle
dependencies {
    implementation 'com.github.doomedcat17:open-translator:Tag'
}
```
## Usage
Create instance of `Translator` class:
```java
Translator translator = new Translator();
```
And translate some text:
```java
Translation translation = translator.translate("Witaj Świecie!", Language.ENGLISH);
System.out.println(translation.getTranslatedText()); // Hello World!
```
**The maximum character limit on a single text is 15k.**

Alternatively, you can create `Translator` using your own `WebClient` implementation :3.

If something goes wrong, `TranslatorException` is thrown.

## Important notes
**This is an unofficial library using web API of Google translator and is not associated with Google. Official API is available [here](https://cloud.google.com/translate/docs).**

Remember that abuse of the library can end with an IP ban from Google. For more data to be translated, I recommend using a proxy.




