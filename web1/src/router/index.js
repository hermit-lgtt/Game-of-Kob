import { createRouter, createWebHistory } from 'vue-router'
import PkIndexView from '../views/pk/PkIndexView'
import RecordIndexView from '../views/record/RecordIndexView'
import RanklistIndexView from '../views/ranklist/RanklistIndexView'
import UserBotIndex from '../views/user/bot/UserBotIndex'
import NotFound from '../views/error/NotFound'

const routes = [
{
  path:"/",
  name:"home",
  redirect:"/pk/",
},
{
  path:"/pk/",
  name:"pk_index",
  component:PkIndexView,
},
{
  path:"/record/",
  name:"record_index",
  component:RecordIndexView,
},
{
  path:"/ranklist/",
  name:"ranklist_index",
  component:RanklistIndexView,
},
{
  path:"/user/bot/",
  name:"user_bot_index",
  component:UserBotIndex,
},
{
  path:"/error/",
  name:"404",
  component:NotFound,
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

export default router
