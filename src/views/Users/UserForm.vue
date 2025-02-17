<template>

  <ContentHeader :title="headerTitle"></ContentHeader>
  
  <common-content>
    <div class="container-fluid">

      <div class="row">

        <div class="col-md-6">

          <div class="card card-primary">


            <div class="card-header">
              <h3 class="card-title">{{ headerTitle }}</h3>
            </div>
            

            <form role="form" @submit.prevent="handleSubmit()">

              <div class="card-body">

                <div class="form-group">
                  <label for="userInput">UserName</label>
                  <input
                    v-model="user.username"
                    type="text"
                    class="form-control"
                    id="userInput"
                    placeholder="Enter username"
                  />
                </div>

                <div class="form-group">
                  <label for="exampleInputEmail">Email address</label>
                  <input
                    v-model="user.email"
                    type="email"
                    class="form-control"
                    id="exampleInputEmail"
                    placeholder="Enter email"
                  />
                </div>

                <div class="form-group">
                  <label>Select UserRole</label>

                  <select class="form-control" v-model="user.userRole.id">

                    <option v-for="role in userRoles" :key="role.id" :value="role.id">
                        {{ role.name }}
                    </option>
                  </select>
                </div>

                <div class="form-group">
                  <label for="address">Address</label>
                  <input
                    v-model="user.address"
                    type="address"
                    class="form-control"
                    id="address"
                    placeholder="Enter address"
                  />
                </div>

              </div>
              
              <div class="card-footer">
                <button type="submit" class="btn btn-primary" >{{ buttonTitle }}</button>
              </div>

            </form>

          </div>

        </div>

      </div>

    </div>
  </common-content>
</template>

<script setup>
import ContentHeader from '@/components/ContentHeader.vue';
import axios from 'axios';
import { useRoute,useRouter } from "vue-router"
import { computed, onMounted, ref } from 'vue';


const user = ref({
    id:'',
    username:'',
    email:'',
    address: '',
    userRole: {
        id:'',
        name:'',
        description:''
    }
});



const isEditing = computed(() => {
  return !!route.params.id
});

const userRoles = ref([]);
const router = useRouter();
const route = useRoute();

const buttonTitle = computed(() => {
  return isEditing.value ? "Update " : "Create "
});

const headerTitle = computed(() => {
  return isEditing.value ? "Edit User" : "Create User"}
);

onMounted(()=>{
    if(isEditing.value){
      fetchUsersById();
    }
    
    fetchUserRoles();
});

const fetchUserRoles = async ()=>{
    const response = await axios.get('http://localhost:8080/api/roles');
    userRoles.value = response.data;
}

const fetchUsersById = async ()=>{
    const userId = route.params.id;
    const response = await axios.get(`http://localhost:8080/api/users/${userId}`);
    user.value = response.data;
}

const updateUserAction = async ()=>{
    await axios.put(`http://localhost:8080/api/users/${user.value.id}`,user.value);
    router.push(`/users/${user.value.id}`)
}

const createUserAction = async ()=>{
  const response = await axios.post(`http://localhost:8080/api/users`,user.value);
  user.value = response.data;
  router.push(`/users/${user.value.id}`)
}

const handleSubmit = () => {
  if(isEditing.value){
    updateUserAction();
  }else{
    createUserAction();
  }
}

</script>
