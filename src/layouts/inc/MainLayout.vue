<template>
  <div class="wrapper">
        <mainNavBar/>
        <mainSideBar/>

    <div class="content-wrapper">
        <router-view />
    </div>

    <footer class="main-footer">
      <div class="float-right d-none d-sm-block"><b>Version</b> 3.2.0</div>
      <strong>Copyright &copy; 2014-2021<a href="https://adminlte.io">AdminLTE.io</a>.</strong>
      All rights reserved.
    </footer>

    <!-- Control Sidebar No need!!-->
    <aside class="control-sidebar control-sidebar-dark"></aside>
   
  </div>
</template>


<script>

  import MainNavBar from "./MainNavBar.vue";
  import MainSideBar from "./MainSideBar.vue";

  export default {
    components: {
      MainNavBar,
      MainSideBar,
    },
};

</script>
