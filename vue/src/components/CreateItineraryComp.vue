<template>
  <div id="create-itenerary">
    <h1>Create an Itenerary:</h1>
    <form id="itenerary">
        <div class="itenerary-name-form">
            <label for="name">Itenerary Name:</label>
            <input id="name" type="text" v-model="newItenerary.name" />
        </div>
        <div class="actions">
            <button v-on:click="resetForm()" type="button">Reset</button>
            <button>Submit</button>
        </div>
    </form>
  </div>
</template>

<script>
export default {
    name: "create-itenerary",
    data() {

    }

}
</script>

<style>

</style>