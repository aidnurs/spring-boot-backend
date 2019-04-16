import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Voting from './views/Voting.vue';
import AllPolls from './views/AllPolls.vue';
import UploadPolls from './views/UploadPolls.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/voting',
      name: 'voting',
      component: Voting,
    },
    {
      path: '/all-polls',
      name: 'all-polls',
      component: AllPolls,
    },
    {
      path: '/upload-polls',
      name: 'upload-polls',
      component: UploadPolls,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ './views/About.vue'),
    },
  ],
});
