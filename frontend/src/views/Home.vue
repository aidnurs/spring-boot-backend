<template>
  <div class="home">
    <div class="" v-for="demo in this.demos">
      {{demo}}
    </div>
    <br>
    <br>
    <div class="" v-for="todo in this.todos">
      {{todo}}
      <p>
        {{todo.text}}
      </p>
      <input type="checkbox" name="" value="" :checked="todo.done">
    </div>
    <form class="" action="index.html" method="post" @submit.prevent="addNewTodo">
      <input type="text" name="text" placeholder="text">
      <input type="text" name="done" placeholder="done">
      <button type="submit" name="button">Submit</button>
    </form>
  </div>
</template>

<script lang="ts">
import Vue from 'vue';
import axios from 'axios';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src

export default Vue.extend({
  name: 'home',
  components: {
    HelloWorld,
  },
  data() {
    return {
      demos: [],
      todos: [],
    };
  },
  methods: {
    addNewTodo(submitEvent) {
      console.log(submitEvent.target.elements.text.value);

      axios
        .post(
          'http://localhost:8090/todos/add',
          submitEvent.target.elements.text.value,
          true,
        )
        .then((response) => {});
    },
  },
  mounted() {
    axios.get('http://localhost:8090/demo/get').then((response) => {
      // console.log(response);
      this.demos = response.data;
    });
    axios.get('http://localhost:8090/todos/get').then((response) => {
      // console.log(response);
      this.todos = response.data;
    });
  },
});
</script>
