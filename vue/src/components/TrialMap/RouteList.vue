<template>
    <section class="route-list-view">
    <div class="route-list-view-header">
        <h3 class="ui header">Route List</h3>
        <select @change="sortRoute($event)">
            <option selected disabled>Sort</option>
            <optgroup label="Distance">
                <option value="distance-asc">short</option>
                <option value="distance-desc">long</option>
            </optgroup>
            <optgroup label="Duration">
                <option value="duration-asc">fast</option>
                <option value="duration-desc">slow</option>
            </optgroup>
        </select>
        <button class="ui button show-all" @click="showAllRoutesButtonPressed">Show All</button>
        <button class="ui button remove-route" @click="removeARoute">Delete A Route</button>
    </div>
    <div class="item" v-for="route in routes" v-bind:key="route.id" @click="routeItemPressed(route)" :style="{'background-color':route.color}" >
        <div><i class="marker alternate icon"></i>{{route.origin.address}}</div>
        <div><i class="flag checkered icon"></i>{{route.destination.address}}</div>
        <div class="ui label small">{{route.distance.text}}</div>
        <div class="ui label small">{{route.duration.text}}</div>
    </div>
    </section>
</template>

<script>

import firebase from 'firebase';
import { EventBus } from '@/EventBus.js';

export default {
    data(){
        return {
            routes: []
        };
    },
    created(){
        const db = firebase.firestore();
        db.collection("routes").onSnapshot(snap =>{
            this.routes = [];
            snap.forEach(doc => {
                let route = doc.data();
                route.id = doc.id;
                this.routes.push(route);    
            })
        });
    },
    methods: {
        sortRoute(e){
            console.log(e.target.value);
            const sortName = e.target.value.split("-")[0];
            const sortOrder = e.target.value.split("-")[1];

            const db = firebase.firestore();
            db.collection("routes").orderBy(sortName + ".value", sortOrder).get()
            .then(snap =>{
                this.routes = [];
              snap.forEach(doc => {
                  let route = doc.data();
                  route.id = doc.id;
                  this.routes.push(route);
              })  
            });
        },
        routeItemPressed(route){
            EventBus.$emit("routes-data", [route]);
        },
        showAllRoutesButtonPressed(){
            EventBus.$emit("routes-data", this.routes);
        },
        removeARoute(){
            const route = this.routes.shift();
            const db = firebase.firestore();
            console.log(route);
            db.collection("routes").doc(route.id).delete()
            .then(() => {
                console.log("Route successfully deleted From Firebase!");
                const index =  this.routes.findIndex(r => r.id === route.id);
                if (index !== -1) {
                    this.routes.splice(index, 1);
                }
            })
            .catch(error => {
                console.error("Error removing document: ", error);
            })
        }
    }

};
</script>


<style >
.route-list-view{
position: relative;
z-index: 1;
max-width: 250px;
margin:10px;
background: white
}

.route-list-view-header{
    padding: 10px;
}

.item{
    padding:10px;
    cursor:pointer;
}
.item:hover{
    background-color: rgba(0,0,0 0.1);

}
.show-all{
    padding:4px 10px;

}
</style>