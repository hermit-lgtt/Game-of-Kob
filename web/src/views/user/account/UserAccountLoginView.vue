<template>
    <ContentField  v-if="!$store.state.user.pulling_info">
        <div class="row justify-content-md-center">
            <div class="col-3">
                <form @submit.prevent="login">
                    <div class="mb-3">
                        <label for = "username" class="form-label">用户名</label>
                        <input v-model="username" type = "text" class="form-control" id = "username" placeholder="请输入用户名">
                    </div>

                    <div class="mb-3">
                        <label for = "password" class="form-label">密码</label>
                        <input v-model="password" type = "password" class="form-control" id = "password" placeholder="请输入密码">
                    </div>
                    
                    <div class="error-message">{{error_message}}</div>
                        
                    <button type="submit" class="btn btn-primary">提交</button>
                
                </form>
            </div>
        </div>



    </ContentField>
</template>

<script>
import ContentField from '../../../components/ContentField.vue'
import { useStore } from 'vuex' 
import{ ref } from 'vue'
import router from '@/router'

export default {
    components:{
        ContentField
    },
    setup(){//所有变量都要用ref,一开始是空的
        const store = useStore();
        let username = ref('');
        let password = ref('');
        let error_message = ref('');

     
        const jwt_token = localStorage.getItem("jwt_token");
        if(jwt_token){
            store.commit("updateToken",jwt_token);
            store.dispatch("getinfo",{
                success(){
                    router.push({name:"home"});
                    store.commit("updatePullingInfo",false);
                },
                error(){
                    store.commit("updatePullingInfo",false);
                }
            })
        }
        else{
            store.commit("updatePullingInfo",false);
        }
      
        const login = () => {//定义一个触发函数，点击后就触发,返回后面的return
            error_message.value = "";
            store.dispatch("login",{//要想调用actions里面的函数的话,用dispatch,这里的actions在user.js里面
                username:username.value,//传值,ref取值的话是用.value
                password:password.value,
                success() {
                    store.dispatch("getinfo", {
                        success(){
                            router.push({ name : 'home' });
                            //console.log(store.state.user);调试信息
                        }
                    })
                   
                    
                },
                error() {
                    error_message.value = "用户名或密码错误";
                }
            })
        }


        return {
            username,
            password,
            error_message,
            login,
          
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