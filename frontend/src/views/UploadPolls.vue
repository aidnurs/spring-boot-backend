<template>
  <div class="">
    <form class="" @submit.prevent="uploadPolls">
      <textarea name="name" rows="8" cols="80" v-model="uploadedPolls"></textarea>
      <button type="submit" name="button">Upload</button>
    </form>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import axios from 'axios';

export default Vue.extend({
  name: '',
  components: {},
  data() {
    return {
      uploadedPolls: '',
    };
  },
  methods: {
    uploadPolls(): any {
      const jsonToSend = { absatz: 'asdasd' };
      axios({
        url: 'http://localhost:8090/polls/upload',
        data: { allPolls: 'asdas' },
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        method: 'post',
      }).then((response) => {});
    },
  },
});
</script>
