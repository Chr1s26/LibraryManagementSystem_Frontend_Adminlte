<template>
  <content-header title="User Listing"></content-header>

  <common-content>
    <div class="container">
      <form class="row g-2 row align-items-center p-4" @submit.prevent="fetchUsers">
        <div class="col-3">
          <input v-model ="searchForm.email" type="text" class="form-control" placeholder="Enter Email" />
        </div>
        <div class="col-3">
          <input
            v-model ="searchForm.username"
            type="text"
            class="form-control"
            placeholder="Enter Username"
          />
        </div>
        <div class="col-3">
          <input v-model ="searchForm.address" type="text" class="form-control" placeholder="Enter Address" />
        </div>
        <div class="col-3 d-flex">
        <button type="submit" class="btn btn-primary" style="margin-right: 10px;">Search</button>
        <button type="button" class="btn btn-primary" @click="clearSearch">Clear</button>
        </div>
      </form>
    </div>
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header">
            <div class="card-tools">
              <router-link
                to="/newUser"
                type="button"
                class="btn btn-blick btn-outline-primary float-right"
                >New User</router-link
              >
            </div>
          </div>

          <div class="card-body">
            <div id="example2_wrapper" class="dataTables_wrapper dt-boostrap4">
              <div class="row">
                <div class="col-sm-12 col-md-6"></div>
                <div class="col-sm-12 col-md-6"></div>
              </div>
              <div class="row">
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th>No</th>
                      <th>User Id</th>
                      <th>UserName</th>
                      <th>Email</th>
                      <th>Address</th>
                      <th>Role</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(user, index) in users" :key="user.id">
                      <td>{{ index + 1 }}</td>
                      <td>{{ user.id }}</td>
                      <td>{{ user.userName }}</td>
                      <td>{{ user.email }}</td>
                      <td>{{ user.address }}</td>
                      <td>{{ user?.userRole?.name || "-" }}</td>
                      <td>
                        <div class="btn-group btn-group-sm">
                          <router-link
                            :to="`/users/${user.id}`"
                            class="btn btn-info"
                            ><i class="fas fa-eye"></i
                          ></router-link>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="row">
                <div class="col-sm-12 col-md-5">
                  <div
                    class="dataTables_info"
                    id="example2_info"
                    role="status"
                    aria-live="polite"
                  >
                    Showing {{ (currentPage - 1) * numberOfPages + 1 }} to
                    {{ Math.min(currentPage * pageSize, totalRecord) }} of
                    {{ totalRecord }} users
                  </div>
                </div>
                <div class="col-sm-12 col-md-7">
                  <div
                    class="dataTables_paginate paging_simple_numbers float_right"
                    id="example2_paginate"
                  >
                    <ul class="pagination">
                      <li
                        class="paginate_button page-item previous"
                        id="example2_previous"
                        :class="{ disabled: currentPage === 1 }"
                      >
                        <a
                          href="#"
                          aria-controls="example2"
                          data-dt-idx="0"
                          tabindex="0"
                          class="page-link"
                          @click="changePage(currentPage - 1)"
                          >Previous</a
                        >
                      </li>
                      <li
                        class="paginate_button page-item"
                        :class="{ active: currentPage === page }"
                        v-for="page in numberOfPages"
                        :key="page"
                      >
                        <a
                          href="#"
                          @click="changePage(page)"
                          aria-controls="example2"
                          data-dt-idx="1"
                          tabindex="0"
                          class="page-link"
                          >{{ page }}</a
                        >
                      </li>

                      <li
                        class="paginate_button page-item next"
                        id="example2_next"
                        :class="{ disabled: currentPage === numberOfPages }"
                      >
                        <a
                          href="#"
                          aria-controls="example2"
                          data-dt-idx="7"
                          tabindex="0"
                          class="page-link"
                          @click="changePage(currentPage + 1)"
                          >Next</a
                        >
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </common-content>
</template>

<script setup>
import axios from "axios";
import { onMounted, ref } from "vue";
import ContentHeader from "@/components/ContentHeader.vue";
import CommonContent from "@/components/CommonContent.vue";
import router from "@/router";

const currentPage = ref(1);
const pageSize = ref(3);
const numberOfPages = ref(0);
const totalRecord = ref(0);
const searchForm = ref({
  email: '',
  username: '',
  address: ''
})

const users = ref([]);



const fetchUsers = async () => {
  const response = await axios.post(`http://localhost:8080/api/users/search?currentPage=${currentPage.value}&pageSize=${pageSize.value}`,searchForm.value)
  numberOfPages.value = response.data.numberOfPages ;
  totalRecord.value = response.data.totalRecords;
  users.value = response.data.data;
};

const clearSearch = () => {
  searchForm.value = { email: "", username: "", address: "" };
  fetchUsers(); 
};

const changePage = (page) => {
  currentPage.value = page;
  fetchUsers();
};

onMounted(fetchUsers);
</script>
