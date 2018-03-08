# TODO Projects [![Build Status](https://www.bitrise.io/app/945976826fface1b/status.svg?token=VbNI8oEqRmVKMw22q7XRSw&branch=develop)](https://www.bitrise.io/app/945976826fface1b)

Sample app to manage the projects and tasks on a Teamwork.com account.

This app contain two screens: The project list, and the tasks associated to a selected project.

## Architecture

The arch of the app is well-known one: 

- Clean Architecture 
- Model View Presenter
- Dagger
- RxJava 2
- Retrofit
- Room

All the code kotlinized


## Tests

The verification of the code has been done through several kind of tests.

### Unit Testing

Evaluation of simple classes which contains certain logic

### Unit Testing

Some UI tests using Espresso library.

### ScreenShot Testing

This kind of tests verify the UI of certain app recording a screenshot over an activity and verify it on CI system.

These tests have been recorded using a Nexus 4 API 22 emulator with an external sd-card

[More information](https://github.com/Karumi/Shot)

### Coverage

Jacoco has been set up in the project to report the code coverage. The reports are saved con each job on the CI system.

## CI

This project is verified on Bitrise CI. Each job executes every unit test on the app.

Due to account limitations, the ScreenShot tests can not be execute on Bitrise.

