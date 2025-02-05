<template>
    <content-header title="User Listing"></content-header>
    <common-content>
        <div class="row">
                <!-- /.card-header -->
                <div class="col-md-12">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th style="">#</th>
                                <th>Id</th>
                                <th>UserName</th>
                                <th>Email</th>
                                <th>Address</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(user,index) in users" :key="user.id">
                            <td>{{  index+1 }}</td>
                            <td>{{ user.id }}</td>
                            <td>{{ user.userName }}</td>
                            <td>{{ user.email }}</td>
                            <td>{{ user.address }}</td>
                            <td>{{ user?.userRole?.name || '-'}}</td>
                            <td><div class="btn-group btn-group-sm">
                            <router-link :to="`/users/${user.id}`" class="btn btn-info"><i class="fas fa-eye"></i></router-link>
                            </div></td>
                            
                            </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </common-content>
</template>

<script>
import axios from "axios";
import { onMounted, ref } from "vue";
export default{
    setup(){
        const users = ref ([]);
        const fetchUsers = async() => {
            const response = await axios.get("http://localhost:8080/api/users?currentPage=1&pageSize=10&username=");
            users.value = response.data.data;
        }
        onMounted(fetchUsers);
        return{
            users
        };
    }
}
</script>