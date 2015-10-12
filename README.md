# QuramiLink 🔗

[ ![Download](https://api.bintray.com/packages/qurami-robot/maven/quramilink/images/download.svg) ](https://bintray.com/qurami-robot/maven/quramilink/_latestVersion)
[ ![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.qurami.android.link/quramilink/badge.svg?style=flat) ](https://maven-badges.herokuapp.com/maven-central/com.qurami.android.link/quramilink/)
[ ![License](https://img.shields.io/badge/license-MIT-lightgrey.svg?style=flat) ](https://github.com/qurami/QuramiLink-Android/blob/master/LICENSE)


## Description

QuramiLink is a convenient class that you can use to open an office page of Qurami directly from your app.  
It checks the availability of Qurami Client on the destination device and, if present, opens the office page.   
All you need to do is to provide a valid office link.   
We will update this class to ensure that any integration with the Qurami Android client will be seamlessly supported.

## Usage 📖

The usage is trivial, just call the static method from the library passing a context and a valid office link:

```
QuramiLink.openQuramiOfficeWithOfficeLink(context, officeLink);
```

Browse our sample code for any doubts :wink:!


## Installation 🔨

QuramiLink is available through [jcenter()](https://bintray.com) repository.
To include it in you project, simply add the following line to your dependencies in build.gradle file:

```
    compile 'com.qurami.android.link:quramilink:0.1.0'
```


## License 📃

QuramiLink is available under the MIT license. See the LICENSE file for more info.
