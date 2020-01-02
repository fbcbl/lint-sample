# Custom Lint 

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

### Defining the rules
We start off by defining a separate module where our rules will be declared. This module is the `rules` module. Then, in order to have our app to integrate with it we add the following code to our app `build.gradle`:

    dependencies {
       ...
       lintChecks project(path: ':rules')
    }

This way, the lint existing in the `rules` module will be compiled into the final `lint.jar` that your app uses.

## Resources

These are useful resources I have found during my Lint learnings:

- [Coding in Style: Static Analysis with Custom Lint Rules (Android Dev Summit '19)](https://www.youtube.com/watch?v=jCmJWOkjbM0)
