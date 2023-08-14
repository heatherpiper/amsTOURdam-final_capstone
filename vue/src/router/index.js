import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/HomeView.vue'
import Login from '../views/LoginView.vue'
import Logout from '../views/LogoutView.vue'
import Register from '../views/RegisterView.vue'
import Landmarks from '../views/LandmarksView.vue'
import AddLandmarks from '../views/AddLandmarksView.vue'
import store from '../store/index'
import LandmarkDetails from '../components/LandmarkDetailComp.vue'
import MyItinerary from '@/views/MyItineraryView.vue'
import CreateItinerary from '@/views/CreateItineraryView.vue'
import MyItineraries from '@/views/MyItinerariesView.vue'
import AdminItineraries from '@/views/AdminItinerariesView.vue'



Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/landmarks',
      name: 'landmarks',
      component: Landmarks,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/landmarks/addlandmarks',
      name: 'addlandmark',
      component: AddLandmarks,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/landmarks/:id',
      name: "landmarkdetail",
      component: LandmarkDetails,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/myitineraries",
      name: 'myitineraries',
      component: MyItineraries,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/myitinerary/:id',
      name: 'myitinerary',
      component: MyItinerary,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/createitinerary',
      name: 'createitinerary',
      component: CreateItinerary,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/itineraries',
      name: 'adminitineraries',
      component: AdminItineraries,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/myitinerary/:itineraryid',
      name: 'deleteitinerary',
      component: MyItinerary,
      meta: {
        requiresAuth: true
      }
    },
    // {
    //   path: '/myitinerary/:itineraryId/addlandmark/:landmarkId',
    //   name: 'addlandmarktoitinerary',
    //   component: AddLandmarksToMyItinerary, 
    //   meta: {
    //     requiresAuth: true
    //   }
    // }
    
  ]

})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else if (to.name ==='addlandmark' && store.state.user.authorities[0].name !== 'ROLE_ADMIN') {
    next('/');
  }
  else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
