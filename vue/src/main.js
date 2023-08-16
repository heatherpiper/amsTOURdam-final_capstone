import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from 'vue2-google-maps'
import "semantic-ui-css/semantic.min.css";
import './/global.css'
import firebase from 'firebase';


Vue.config.productionTip = false


// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCOA0tbaaCMtXQ3jxuvqtY3CB62Nq83Wzs",
  authDomain: "amstourdam-9b514.firebaseapp.com",
  projectId: "amstourdam-9b514",
  storageBucket: "amstourdam-9b514.appspot.com",
  messagingSenderId: "422045294229",
  appId: "1:422045294229:web:8481db89e4f462ced9c59c",
  measurementId: "G-L93YX3M9VL"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);

console.log(firebase);


Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyCTlYcOo1geGmvoTzPWWOAc-2VjQsNcAGw",
    libraries: 'places, directions'
  }
});

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
