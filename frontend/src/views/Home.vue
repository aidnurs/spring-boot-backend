<template>
  <div class="home">
    <div class="" v-for="(todo,key) in this.todos">
      <!--{{todo}}-->
      {{todo.id}}
      {{todo.text}}
      <input type="checkbox" name="" value="" :checked="todo.done">
      <button type="button" class="close" aria-label="Close" @click="deleteTodo(todo.id,key)">
        <span aria-hidden="true">&times;</span>
      </button>
      </div>
    <form class="" method="post" @submit.prevent="addNewTodo">
      <label for="text">text</label>
      <input type="text" name="text" placeholder="text" v-model="text">
      <label for="done">done</label>
      <input type="checkbox" name="done" v-model="done">
      <button type="submit" name="button">Submit</button>
    </form>
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
      text: '',
      done: false,
    };
  },
  methods: {
    addNewTodo() {
      const jsonToSend = { text: this.text, done: this.done };
      axios({
        url: 'http://localhost:8090/todos/add',
        method: 'post',
        data: jsonToSend,
      }).then(() => {
        this.todos.push(jsonToSend);
      });
    },
    changeTodo() {
      axios({
        url: 'http://localhost:8090/todos/change/' + id,
        method: 'put',
      }).then(() => {});
    },
    deleteTodo(id: number, key: number) {
      axios({
        url: 'http://localhost:8090/todos/delete/' + id,
        method: 'delete',
      }).then(() => {
        this.todos.splice(key, 1);
      });
    },
  },
  mounted() {
    axios.get('http://localhost:8090/todos/get').then((response) => {
      // console.log(response);
      this.todos = response.data;
    });
  },
});
</script>
