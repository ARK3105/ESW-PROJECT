# Adaptive Object Detection MObile Application

This Android application demonstrates automatic switching of machine learning (ML) models based on battery level, CPU usage, and battery consumption. The application uses TensorFlow Lite to perform object detection and selects the appropriate ML model based on the current device conditions.

## Features

- Automatic switching of ML models based on battery level, CPU usage, and battery consumption.
- Supports multiple ML models, including EfficientDet Lite0, EfficientDet Lite1, EfficientDet Lite2, and MobileNet V1.
- Real-time monitoring of battery level, CPU usage, and battery consumption.
- Logging of device conditions and selected ML model to a log file.

## Prerequisites

To use this application, you need:

- Android Studio 4.0 or later.
- Android device or emulator running Android 5.0 (API level 21) or higher.

## Installation

1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the application on your Android device or emulator.

## Usage

1. Launch the application on your Android device.
2. The application will start monitoring the battery level, CPU usage, and battery consumption.
3. The UI will display real-time values for battery level, CPU usage, and battery consumption.
4. The selected ML model based on the current device conditions will be shown in the UI.
5. The application logs the device conditions and selected ML model to a log file.

## Logging

The application logs the following information to a log file:

- Timestamp: The timestamp of the log entry.
- Selected Model: The ML model selected based on the current device conditions.
- Battery Level: The current battery level of the device.
- CPU Usage: The current CPU usage of the device.
- Battery Consumption: The estimated battery consumption based on CPU usage.

The log file is stored in the internal storage of the application. You can access the log file using a file manager or by connecting your device to a computer and accessing the internal storage.

- [Download Log File](https://drive.google.com/file/d/1Jc3n7DtYvnC6ae5eja_vfDTdTdvzIhL7/view?usp=drive_link)

## Customization

You can customize the logic for ML model switching by modifying the `updateSelectedModel()` function in the `MainActivity` class. This function uses the battery level, CPU usage, and battery consumption to determine the most suitable ML model. Modify the logic in this function to fit your requirements.

## Downloads

- [ML Android File Navigation Guideline (PDF)](https://drive.google.com/file/d/1PYpoQMKLeFU8U9EItEi4QOHyylrAzuAL/view?usp=drive_link)
- [Android File](https://drive.google.com/file/d/1A8DL4oQ8xh027lDx9bYLcY74ly2E6M8d/view?usp=drive_link)
- [ZIP File](https://drive.google.com/file/d/1Jc3n7DtYvnC6ae5eja_vfDTdTdvzIhL7/view?usp=drive_link)
- [APK File](https://drive.google.com/file/d/1A8DL4oQ8xh027lDx9bYLcY74ly2E6M8d/view?usp=drive_link)

## Screenshots

![Screenshot 1](https://github.com/sa4s-serc/AdaMLS_Mobile/blob/main/ss1.jpg)
![Screenshot 2](https://github.com/sa4s-serc/AdaMLS_Mobile/blob/main/ss2.jpg)
![Screenshot 3](https://github.com/sa4s-serc/AdaMLS_Mobile/blob/main/ss3.jpg)


## License

This project is licensed under the [Apache License 2.0](LICENSE).

## Acknowledgements

This application is based on the TensorFlow Lite Object Detection example. The original source code can be found [here](https://github.com/tensorflow/examples/tree/master/lite/examples/object_detection).
