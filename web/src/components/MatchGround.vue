<template>
    <div class="matchground">
        <div class="row">
            <div class="col-6">
                <div class="user-photo">
<<<<<<< HEAD
                    <img :src="$store.state.user.photo" alt="" >
                </div>
                <div class="user-username">
                    {{ $store.state.user.username }}

=======
                    <img :src="$store.state.user.photo" alt="">
                </div>
                <div class="user-username">
                    {{ $store.state.user.username }}
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
                </div>
            </div>
            <div class="col-6">
                <div class="user-photo">
<<<<<<< HEAD
                    <img :src="$store.state.pk.opponent_photo" alt="" >
=======
                    <img :src="$store.state.pk.opponent_photo" alt="">
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
                </div>
                <div class="user-username">
                    {{ $store.state.pk.opponent_username }}
                </div>
            </div>
<<<<<<< HEAD

            <div class="col-12" style="text-align: center;padding-top: 15vh; ">
               <button @click="click_match_btn" type = "button" class="btn btn-warning btn-lg">{{match_btn_info}}</button>
            </div>
        </div>

=======
            <div class="col-12" style="text-align: center; padding-top: 15vh;">
                <button @click="click_match_btn" type="button" class="btn btn-warning btn-lg">{{ match_btn_info }}</button>
            </div>
        </div>
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    </div>
</template>

<script>
<<<<<<< HEAD

import{ref} from 'vue';
import{ useStore }from 'vuex';

export default {
    setup(){
        const store = useStore();
        let match_btn_info = ref("开始匹配");

        const click_match_btn =()=>{
            if(match_btn_info.value==="开始匹配"){
                match_btn_info.value ="取消";
                store.state.pk.socket.send(JSON.stringify({
                    event:"start-matching",

                }));
            }else{
                match_btn_info.value="开始匹配";
                store.state.pk.socket.send(JSON.stringify({
                    event:"stop-matching",

                }));
            }
        }
=======
import { ref } from 'vue'
import { useStore } from 'vuex';

export default {
    setup() {
        const store = useStore();
        let match_btn_info = ref("开始匹配");

        const click_match_btn = () => {
            if (match_btn_info.value === "开始匹配") {
                match_btn_info.value = "取消";
                store.state.pk.socket.send(JSON.stringify({
                    event: "start-matching",
                }));
            } else {
                match_btn_info.value = "开始匹配";
                store.state.pk.socket.send(JSON.stringify({
                    event: "stop-matching",
                }));
            }
        }

>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
        return {
            match_btn_info,
            click_match_btn,
        }
    }
}
</script>

<style scoped>
<<<<<<< HEAD
div.matchground{
    width: 60vw;
    height: 70vh;
    margin: 40px auto;
    background-color: rgba(50, 50, 50,0.5);
}
div.user-photo{
    text-align: center;
    padding-top: 10vh;
}
div.user-photo >img{
    border-radius: 50%;
    width: 25vh;
}

div.user-username{
    text-align: center;
    font-size: 24px;
    font-weight: 600;
    color:white;
    padding-top: 2vh;

}

</style>
=======
div.matchground { 
    width: 60vw;
    height: 70vh;
    margin: 40px auto;
    background-color: rgba(50, 50, 50, 0.5);
}
div.user-photo {
    text-align: center;
    padding-top: 10vh;
}
div.user-photo > img {
    border-radius: 50%;
    width: 20vh;
}
div.user-username {
    text-align: center;
    font-size: 24px;
    font-weight: 600;
    color: white;
    padding-top: 2vh;
}
</style>

>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
