# Custom Lint Rules

In this sample project you will be able to see how to define your own custom lint checks.

## To-do

- [x] Java/Kotlin rule
- [ ] XML rule.
- [ ] Testing
- [ ] Adding suggestions

### Defining the dependencies

We start off by defining a separate module where our rules will be declared. This module is the `rules` module. We then go to the `rules/build.gradle` and add the following dependencies:

    dependencies {
     compileOnly "com.android.tools.lint:lint-api:lint-version"
     compileOnly "com.android.tools.lint:lint-checks:lint-version"
    }

**Important**: For historical reasons, your lint version should correspond to the Android Gradle Plugin version + 23. This is, if your AGP is 3.5.1, then your lint version should be 26.5.1

Afterwards, so that our app to integrates with the rules we will create we add the following code to our app `build.gradle`:

    dependencies {
           ...
           lintChecks project(path: ':rules')
    }

This way, the lint rules existing in the `rules` module will be compiled into the final `lint.jar` that your app uses.

## Issues and Detectors

Since our initial setup is done, we can now understand how to build the rules. For that we need to understand two fundamental concepts: Issues and Detectors.

### What is an Issue?

As per the documentation, an Issue **is a potential bug in an Android application.** It is the way you declare the bug your rule should tackle.

An issue has the following base structure:

- `id` - in order to identify uniquely this issue
- `briefDescription` - summarised description of the issue
- `explanation` - should be a more in-depth description of the issue and ideally on how it should be solved
- `category` - identifies the type of the issue. There are a lot of possible categories such as `CORRECTNESS`, `USABILITY`, `I18N`, `COMPLIANCE`, `PERFORMANCE`, ...
- `priority` - a number between 1 and 10, where the bigger the number the more severe the issue is
- `severity` - it can be one of the following values: `FATAL`, `ERROR`, `WARNING`, `INFORMATIONAL` and `IGNORE` . **Note:** If the severity is either `FATAL` or `ERROR` then running `lint` will fail and you will have to address the issue.
- `implementation` - the class responsible for analyzing files and detecting the issue

### What is a Detector?

A `Detector` is a class that is able to find one/more specific issues. According to the `Issue` that we have to detect, we can use different types of  `Detector` that provide better interfaces to different file types:

- `SourceCodeScanner` - a detector specialised in Java/Kotlin source files
- `XmlScanner` - a detector specialised in XML files
- `GradleScanner` - a detector specialised in Gradle files
- `ResourceFolderScanner` - a detector specialised in resource folders (not the files that it contains)

## Resources

These are useful resources I have found during my Lint learnings:

**Talks:**
- [Getting the Most Out of Android Lint (Android Dev Summit' 18)](https://www.youtube.com/watch?v=ffH-LD5uP4s)
- [Coding in Style: Static Analysis with Custom Lint Rules (Android Dev Summit '19)](https://www.youtube.com/watch?v=jCmJWOkjbM0)

**Repositories:**
- [Lint Experiments](https://github.com/tikurahul/lint-experiments)
- [@vanniktech lint-rules](https://github.com/vanniktech/lint-rules)