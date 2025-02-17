<template>

  <!-- <ContentHeader ></ContentHeader> -->
  <content-header title="Home"></content-header>

  <div class="home">
  </div>

</template>


<script lang="ts">

import { Options, Vue } from 'vue-class-component';
import HelloWorld from '@/components/HelloWorld.vue'; // @ is an alias to /src
import ContentHeader from '@/components/ContentHeader.vue';


@Options({
  components: {
    HelloWorld,
    ContentHeader
  },
})

export default class HomeView extends Vue {}

</script>
