# Asteroid Radar Android App

The Asteroid Radar Android App is a powerful and informative application that allows users to explore asteroids detected by NASA as they pass near Earth. This app provides detailed information about these asteroids, including their size, velocity, distance to Earth, and whether they are potentially hazardous. The project showcases essential Android development skills, such as fetching data from the internet, saving data to a database, and presenting data through a clear and compelling user interface.

## Getting Started

To use the Asteroid Radar app, follow these steps:

1. API Key Setup: Obtain an API key from NASA JPL Asteroid team and add it to the local.properties file. This key is necessary to access the Near Earth Object Web Service (NeoWS) API securely.

2. Installation: Download and install the app on your Android device from the Google Play Store (if available).

3. Launch the App: Open the app by tapping on its icon in your app drawer.

4. Explore Asteroids: Use the app to explore a list of clickable asteroids on the main screen.

5. View Asteroid Details: Click on an asteroid to access the details screen, displaying comprehensive information about the selected asteroid.

6. Data Synchronization: The app fetches asteroid data from the NASA NeoWS API, and once saved in the database, it displays the list of asteroids.

7. Background Updates: Asteroid data is cached through a worker, allowing the app to download and save new asteroid data in the background when the device is charging and connected to Wi-Fi. Additionally, it deletes asteroid data from the previous day.

8. Accessibility: The app is designed to work on multiple screen sizes and orientations, and it provides accessibility features such as TalkBack and push-button navigation.

## Technologies and Features

- **Modern Android Development**: The app is built using the latest Android development tools, including Kotlin, Coroutines, Architecture Components, MVVM (Model-View-ViewModel) architecture, and Material Design components.

- **Data Retrieval**: The app fetches asteroid data from the NASA NeoWS API, ensuring the data is always up-to-date.

- **Data Storage**: Asteroid data is saved locally using a database (Room) to ensure offline access and data persistence.

- **Worker for Background Tasks**: The app utilizes a worker to download and cache asteroid data in the background.

- **Accessibility**: The app supports accessibility features, including TalkBack and push-button navigation, to enhance usability for all users.

## Screenshots

![Screenshot (7)](https://user-images.githubusercontent.com/87489620/200381154-7398b2a5-6827-4779-94c8-944abedf7e75.png)


![Screenshot (8)](https://user-images.githubusercontent.com/87489620/200381156-4078f05b-376c-4224-8e91-ca59d648d027.png)

## Contributing

We welcome contributions from the Android development community. If you'd like to contribute to the development of the Asteroid Radar app, please follow our contribution guidelines in the CONTRIBUTING.md file.

## License

This project is licensed under the MIT License. For details, see the LICENSE.md file.
