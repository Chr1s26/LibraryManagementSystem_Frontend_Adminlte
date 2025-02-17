<template>

    <!-- Side bar item  -->
    <li class="nav-item">

        <!-- To go to the link when click and selected one to be active -->
        <router-link class="nav-link" :to="link" :class="{active: isActive()}">

            <!-- To customize side bar item icon -->
            <i class="nav-icon" :class="icon" v-if="icon"></i>

            <!-- To customize any words we like we use slot -->
            <p><slot/></p>

        </router-link>

    </li>

</template>

<script>
  export default{

      props:{
          icon:{
              type: String,
              default: null
          },
          
          link:{
              type: [String, Object],
              default: null
          }
      },

      methods:{
          isActive(){
              if(typeof this.link === "object"){
                  return this.$route.name === this.link.name;
              }else{
                  return this.$route.path === this.link;
              }
          }
      }
  }

</script>