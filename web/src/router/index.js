import { createRouter, createWebHistory } from 'vue-router'
import PkIndexView from '../views/pk/PkIndexView'
import RecordIndexView from '../views/record/RecordIndexView'
import RecordContentView from '../views/record/RecordContentView'
import RanklistIndexView from '../views/ranklist/RanklistIndexView'
import UserBotIndex from '../views/user/bot/UserBotIndex'
import NotFound from '../views/error/NotFound'
import UserAccountLoginView from '../views/user/account/UserAccountLoginView'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView'
import store from '../store/index'
  


const routes = [
{
  path:"/",
  name:"home",
  redirect:"/pk/",
  meta :{
    RequestAuth:true,//设置为授权页面
  }
  
},
{
  path:"/pk/",
  name:"pk_index",
  component:PkIndexView,
  meta :{
    RequestAuth:true,//设置为授权页面
  }
},
{
  path:"/record/",
  name:"record_index",
  component:RecordIndexView,
  meta :{
    RequestAuth:true,//设置为授权页面
  }
},


{
  path:"/record/:recordId/",
  name:"record_content",
  component:RecordContentView,
  meta :{
    RequestAuth:true,//设置为授权页面
  }
},

{
  path:"/user/bot/",
  name:"user_bot_index",
  component:UserBotIndex,
  meta :{
    RequestAuth:true,//设置为授权页面
  }
},

{
  path:"/ranklist/",
  name:"ranklist_index",
  component:RanklistIndexView,
  meta :{
    RequestAuth:true,//设置为授权页面
  }
},

{
  path:"/user/account/login/",
  name:"user_account_login",
  component:UserAccountLoginView,
  meta :{
    RequestAuth:false,//设置为授权页面
  }
},

{
  path:"/user/account/register/",
  name:"user_account_register",
  component:UserAccountRegisterView,
  meta :{
    RequestAuth:false,//设置为授权页面
  }
},


{
  path:"/error/",
  name:"404",
  component:NotFound,
  meta :{
    RequestAuth:false,//设置为授权页面
  }
},
{
  path:"/:catchAll(.*)",
  redirect:"/error/",
}

]

const router = createRouter({
  history: createWebHistory(),
  routes
})
router.beforeEach((to,from,next)=>{
  if(to.meta.RequestAuth && !store.state.user.is_login){
    next({name:"user_account_login"})
  }else{
    next();
  }

})

export default router
