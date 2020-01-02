# Custom Lint Rules

In this sample project you will be able to see how to define your own custom lint checks.

## To-do

- [ ] Initial setup
- [ ] Testing
- [ ] Adding suggestions

## Initial Setup

### Defining the dependencies

In order to create your own custom lint rules you need to add the following dependencies:
- `com.android.tools.lint:lint-api:lint-version`
- `com.android.tools.lint:lint-checks:lint-version`

> **Important**: For historical reasons, your lint version should correspond to the Android Gradle Plugin version + 23. This is,
if your AGP is 3.5.1, then your lint version should be 26.5.1

## Issue Registry

Since we have created our first rule, then we have to make it visible to the Android Lint engine. The way we do it is via a 
`IssueRegistry`, which has the sole responsibility of defining the issues and their detectors. 

```kotlin 

class IssueRegistry: IssueRegistry() {

    override val issues: List<Issue>
        get() = emptyList()
}
```

**However**, in order to Android Lint to discover our `IssueRegistry` we 
have to declare a *Service Locator*. This *Service Locator* is defined in a 
specific location in our `resources` folder. To define it, we create this file entry:

#### **`rules/src/main/resources/META-INF/services/com/android/tools/lint/client/api/IssueRegistry`**
```
com.fabiocarballo.rules.IssueRegistry
```

### Defining the rules
We start off by defining a separate module where our rules will be declared. This module is the `rules` module. Then, in order to have our app to integrate with it we add the following code to our app `build.gradle`:

```gradle
dependencies {
       ...
       lintChecks project(path: ':rules')
}
```

This way, the lint rules existing in the `rules` module will be compiled into the final `lint.jar` that your app uses.

### Running the rules

In order to run the rules in your app just run:  `./gradlew app:lintDebug` 

## Resources

These are useful resources I have found during my Lint learnings:

**Talks:**
- [Coding in Style: Static Analysis with Custom Lint Rules (Android Dev Summit '19)](https://www.youtube.com/watch?v=jCmJWOkjbM0)

**Repositories:**
- [Lint Experiments](https://github.com/tikurahul/lint-experiments)
- [@vanniktech lint-rules](https://github.com/vanniktech/lint-rules)