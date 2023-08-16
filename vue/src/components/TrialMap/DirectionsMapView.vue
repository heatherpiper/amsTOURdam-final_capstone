<template>
  <section class="map" ref="map"></section>
</template>

<script>
import { EventBus } from "@/EventBus.js";

export default {
  mounted() {
    // eslint-disable-next-line no-undef
    const map = new google.maps.Map(this.$refs["map"], {
      // eslint-disable-next-line no-undef
      center: new google.maps.LatLng(52.3676, 4.9041),
      zoom: 15,
      // eslint-disable-next-line no-undef
      mapTypeId: google.maps.MapTypeId.ROADMAP,
    });

    // eslint-disable-next-line no-undef
    const directionsService = new google.maps.DirectionsService();
    // eslint-disable-next-line no-undef
    const directionsRenderer = new google.maps.DirectionsRenderer();

    EventBus.$on("route-data", ({ origin, destination }) => {
      directionsService.route({
        origin: origin.address,
        destination: destination.address,
        travelMode: "DRIVING"
      },
      (response, status) => {
          if(status === "OK"){
              directionsRenderer.setDirections(response);
              directionsRenderer.setMap(map);
          }
          console.log(response);
          console.log(status);
      }
      );
    });
    EventBus.$on("routes-data", routes => {
        routes.forEach(({ origin, destination, distance, duration }) => {
            directionsService.route({
                origin:origin.address,
                destination:destination.address,
                travelMode: "DRIVING"
            },
            (response,status) => {
                if(status === "OK"){
                    // eslint-disable-next-line no-undef
                    const directionsRenderer = new google.maps.DirectionsRenderer({
                        //suppressMarkers = true

                    });

                    this.createInfoWindowWith(origin, "marker alternate", map);
                    this.createInfoWindowWith(destination, "flag checkered", map);

                    const overviewPath = response.routes[0].overview_path;
                    const middleIndex = parseInt(overviewPath.length / 2);
                    const middleLoc = overviewPath[middleIndex];

                    // eslint-disable-next-line no-undef
                    const distanceDurationLabel = new google.maps.InfoWindow({
                        content: `<i class="icon car"></i> ${distance.text} -${duration.text}`,
                        // eslint-disable-next-line no-undef
                        position: new google.maps.LatLng(middleLoc.lat(), middleLoc.lng())
                    });
                    distanceDurationLabel.open(map, null);


                    directionsRenderer.setDirections(response);
                    directionsRenderer.setMap(map);
                
            }
            });

        });
    });
  },
  methods: {
      createInfoWindowWith(location, icon, map){
           // eslint-disable-next-line no-undef
                    const infoWindow = new google.maps.InfoWindow({
                        content:`<i class="${icon} icon"></i> ${location.address}`,
                        // eslint-disable-next-line no-undef
                        position: new google.maps.LatLng(location.lat, location.lng)
                    });

                    infoWindow.open(map, null);

      }

  }

};
</script>


<style >
.map {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: red;
}
.gm-style-iw button{
    display: none !important;

}
.gm-style .gm-style-iw-c{
    padding:5px !important;

}
.gm-style-iw-d{
    overflow:hidden !important;
}
</style>