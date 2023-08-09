<template>
    <ContentField>
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form @submit.prevent="register">
                    <div class="mb-3">
                        <label for = "username" class="form-label">用户名</label>
                        <input v-model="username" type = "text" class="form-control" id = "username" placeholder="请输入用户名">
                    </div>

                    <div class="mb-3">
                        <label for = "password" class="form-label">密码</label>
                        <input v-model="password" type = "password" class="form-control" id = "password" placeholder="请输入密码">
                    </div>

                    <div class="mb-3">
                        <label for = "password" class="form-label">确认密码</label>
                        <input v-model="confirmedpassword" type = "password" class="form-control" id = "cofirmedpassword" placeholder="请再次输入密码">
                    </div>
                    
                    <div class="error-message">{{error_message}}</div>
                        
                    <button type="submit" class="btn btn-primary">提交</button>
                
                </form>
            </div>
        </div>



    </ContentField>
</template>

<script>
import ContentField from '../../../components/ContentField.vue'//如果是export default 就可以不加{}任意取名
import {ref} from 'vue'
import router from '@/router';

import $ from 'jquery'


export default {
    components:{
        ContentField
    },
    setup(){
        
        let username = ref('');
        let password = ref('');
        let confirmedpassword = ref('');
        let error_message = ref('');

        const register = () =>{//写个回调函数
            $.ajax({
                url:"http://127.0.0.1:3000/user/account/register/",
                type:"post",//一般来说,只获得数据库中的数据,不修改的话,用get,要修改的话,用post
                data:{
                    username:username.value,
                    password:password.value,
                    confirmedpassword:confirmedpassword.value,
                },
                //headers:{Authorization:"Bearer " +store.state.user.token,},授权，但是注册不需要授权
                
                success(resp){//js很灵活,这里是字典
                    if(resp.error_message ==="success"){
                        router.push({name:"user_account_login"});
                    }else{
                        error_message.value = resp.error_message;
                    }
                },
            
                
            })
        }

        return {
            username,
            password,
            confirmedpassword,
            error_message,
            register,
        }
    }
}
</script>

<style scoped>

button{
    width: 100%;
}
div.error-message{
    color: red;
}


</style>