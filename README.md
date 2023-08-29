# City Tour Application - Final Capstone Project for Tech Elevator

**amsTOURdam** is an application that allows users to create custom itineraries from a curated list of experiences and activities within the city of Amsterdam.

Users can search and browse a database of landmarks, drag landmark cards into and out of itineraries for easy editing, build custom color-coded routes, and upload photos of their travels.

Tools: Java, Spring Boot, PostgreSQL, Vue.js, HTML, CSS, JavaScript, GitLab, Google Maps API, Cloudinary API

See descriptions above each photo for more information about the features of amsTOURdam.

## Screenshots

### Explore Locations 

Map displays pinned location of each Landmark along with an input box to add a new pinned location.
![Screenshot of Explore Locations page](/vue/src/media/assets/explore-locations.png "Explore Locations")

### Landmarks with pinned locations

Landmarks page shows list of all Landmarks and a map displaying their pinned locations.
![Screenshot of Landmarks page with map showing pinned locations](/vue/src/media/assets/landmarks-page.png "Landmarks Page")

### Hot Spots in Amsterdam

Landmarks page displays a card with a name, photo, and brief description of each Landmark. Clicking each card will display a more detailed view of each Landmark with additional details such as the cost of admission or any historical notes of interest.
![Screenshot of full list of Landmarks](/vue/src/media/assets/landmarks.png "Landmarks")

### Itineraries

Users can create multiple Itineraries to keep track of the Landmarks they are interested in. Itineraries can be used to help plan for situations where multiple family members might want to visit different sites on different days or when rain might cause plans to be altered, for instance.
![Screenshot of Itineraries page](/vue/src/media/assets/itineraries.png "Itineraries")

### Editing Itineraries

When viewing an Itinerary, users are able to simply drag Landmark cards in and out of the box to add or remove them from the Itinerary. The map above automatically updates to show the pinned locations only of the Landmarks currently in the Itinerary.
![Screenshot of Itinerary drag-to-edit feature](/vue/src/media/assets/draggable-itinerary.png "Draggable Editing of Itineraries")

### Map Your Way

Using the Google Maps API, Users can plot multiple routes between locations of their choosing. Routes are color coded, and users can choose which routes are displayed by simply clicking the route boxes on the left to toggle.
![Screenshot of Map Your Way page with custom routes plotted](/vue/src/media/assets/map-your-way.png "Map Your Way")

### Upload Photos of Your Visit

Using the Cloudinary API, users can visit a Landmark page to add their own photos from their visit to Amsterdam.
![Screenshot showing upload photos menu](/vue/src/media/assets/upload-photos.png "Upload Photos")
