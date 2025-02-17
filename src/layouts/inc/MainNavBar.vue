<template>
    
    <!-- main nav bar -->

    <nav class="main-header navbar navbar-expand navbar-white navbar-light">

        <!-- main nav bar push button  -->

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
        </ul>

        <!-- profile person profile location -->

        <ul class="navbar-nav ml-auto">
          
          <!-- Messages Dropdown Menu of person profile -->

            <li class="nav-item dropdown">

                <!-- person icon -->

                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-user"></i>
                </a>

                <!-- dropdown menu item  -->

                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item"><i class="fas fa-user mr-2"></i>My Profile</a>

                    <!-- divider line between myprofile and logout item -->
                    <div class="dropdown-divider"></div>

                    <a href="#" class="dropdown-item"><i class="fas fa-sign-out-alt mr-2"></i>Log Out</a>
                  
                </div>

            </li>
          
        </ul>
    </nav>

  
</template>