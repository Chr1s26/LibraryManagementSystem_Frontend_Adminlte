<template>
  <content-header title="User Profile"></content-header>
  <common-content>
    <div class="col-md-3">
      <!-- Profile Image -->
      <div class="card card-primary card-outline">
        <div class="card-body box-profile">
          <div class="text-center">
            <img
              class="profile-user-img img-fluid img-circle"
              src="/adminlte/dist/img/user4-128x128.jpg"
              alt="User profile picture"
            />
          </div>

          <h3 class="profile-username text-center">{{ user?.username}}</h3>

          <p class="text-muted text-center">{{ user?.userRole?.name }}</p>

          <ul class="list-group list-group-unbordered mb-3">
            <li class="list-group-item">
              <b>Id</b> <a class="float-right">{{ user?.id }}</a>
            </li>
            <li class="list-group-item">
              <b>Email</b> <a class="float-right">{{ user?.email }}</a>
            </li>
            <li class="list-group-item">
              <b>Address</b> <a class="float-right">{{ user?.address }}</a>
            </li>
          </ul>

          <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a>
        </div>
        <!-- /.card-body -->
      </div>
    </div>
  </common-content>
</template>



<script>
import axios from "axios";
import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";

    export default{
        setup(){
            const route = useRoute();
            const user = ref({
                id : null,
                username : '',
                email: '',
                address: '',
                userRole: null

            });

            const fetchUsersById = async () => {
                const userId= route.params.id;
                const response = await axios.get(`http://localhost:8080/api/users/${userId}`)
                console.log(response.data)
                user.value = response.data
            };

            onMounted(fetchUsersById);
            return {user};
        }
    }
</script>
