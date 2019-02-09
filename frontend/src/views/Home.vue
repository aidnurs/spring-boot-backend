<template>
  <div class="home">
    <div class="" v-for="todo in this.todos">
      {{todo}}
      {{todo.text}}
      <input type="checkbox" name="" value="" :checked="todo.done">
    </div>
    <!--<form class="" action="index.html" method="post" @submit.prevent="addNewTodo">
      <label for="text">text</label>
      <input type="text" name="text" placeholder="text">
      <label for="done">done</label>
      <input type="checkbox" name="done">
      <button type="submit" name="button">Submit</button>
    </form>-->
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
      todos: [],
    };
  },
  mounted() {
    axios.get('http://localhost:8090/todos/get').then((response) => {
      // console.log(response);
      this.todos = response.data;
    });
  },
});
</script>
