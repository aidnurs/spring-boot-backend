<template>
  <div class="" style="max-width:1200px;margin:0 auto;">
    <p>
      {{getAbsatz.absatz}}
    </p>
    <form class="" action="index.html" method="post" @submit.prevent="nextAbsatz(getAbsatz)">
      <div class="">
        <select class="" name=""  v-model="chosenLabel">
          <option v-for="label in labels">{{label}}</option>
        </select>
      </div>
      <button type="submit" name="button">Next</button>
    </form>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import axios from 'axios';
import labels from '@/assets/AGB_Labels.json';
import absaetze from '@/assets/AGB_Absaetze.json';

export default Vue.extend({
  name: 'voting',
  components: {},
  data() {
    return {
      labels: labels.labels,
      absaetze: new Array(),
      chosenLabel: String,
    };
  },
  computed: {
    getAbsatz(): any {
      const vm = this;
      return vm.absaetze[Math.floor(Math.random() * vm.absaetze.length)];
    },
  },
  mounted() {
    axios.get('http://localhost:8090/polls/get-no-label').then((response) => {
      this.absaetze = response.data;
    });
  },
  methods: {
    nextAbsatz(absatz) {
      const jsonToSend = { absatz: absatz.absatz, label: this.chosenLabel };
      console.log(jsonToSend);
      axios({
        url: 'http://localhost:8090/polls/change/' + absatz.id,
        data: jsonToSend,
        method: 'put',
      }).then((response) => {
        console.log(response);
        this.chosenLabel = '';
      });
    },
  },
});
</script>
