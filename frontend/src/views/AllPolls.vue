<template>
  <div class="">
    <div v-for="poll in polls">
      <p>
        {{poll.absatz}}
      </p>
      <div class="">
        {{poll.label}}

      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import axios from 'axios';

export default Vue.extend({
  name: 'home',
  components: {},
  data() {
    return {
      polls: new Array(),
    };
  },
  mounted() {
    axios.get('http://localhost:8090/polls/get').then((response) => {
      this.polls = response.data;
    });
  },
});
</script>
