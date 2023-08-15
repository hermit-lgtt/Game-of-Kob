<template>
<<<<<<< HEAD
    <PlayGround v-if ="$store.state.pk.status ==='playing'"></PlayGround>
    <MatchGround v-if="$store.state.pk.status==='matching'"></MatchGround>
=======
    <PlayGround v-if="$store.state.pk.status === 'playing'" />
    <MatchGround v-if="$store.state.pk.status === 'matching'" />
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
</template>

<script>
import PlayGround from '../../components/PlayGround.vue'
import MatchGround from '../../components/MatchGround.vue'
<<<<<<< HEAD

import {onMounted,onUnmounted} from 'vue'
import{ useStore }from 'vuex'

export default{
    components:{
        PlayGround,
        MatchGround,
    },
    setup(){
        const store = useStore();
        const socketUrl = `ws://127.0.0.1:3000/websocket/${store.state.user.token}/` ;
        
        let socket = null;
        onMounted(()=>{
            store.commit("updateOpponent",{
                username:"我的对手",
                photo:"https://cdn.acwing.com/media/article/image/2022/08/09/1_1db2488f17-anonymous.png"
            })
            socket = new WebSocket(socketUrl);
        
            socket.onopen =() =>{
                console.log("connected");
                store.commit("updateSocket",socket);
            }

            socket.onmessage = msg =>{
                const data = JSON.parse(msg.data);
                if(data.event ==="start-matching"){
                    store.commit("updateOpponent",{
                        username:data.opponent_username,
                        photo:data.opponent_photo,
                    });
                    setTimeout(()=>{
                        store.commit("updateStatus","playing");
                    },2000);
                    store.commit("updateGamemap",data.gamemap);
                   
                }
                console.log(data);
            } 

            socket.onclose = ()=>{
                console.log("disconnected");
            }
        });

        onUnmounted(()=>{
            socket.close();
            store.commit("updateStatus","matching");
        })

=======
import { onMounted, onUnmounted } from 'vue'
import { useStore } from 'vuex'

export default {
    components: {
        PlayGround,
        MatchGround,
    },
    setup() {
        const store = useStore();
        const socketUrl = `ws://127.0.0.1:3000/websocket/${store.state.user.token}/`;

        let socket = null;
        onMounted(() => {
            store.commit("updateOpponent", {
                username: "我的对手",
                photo: "https://cdn.acwing.com/media/article/image/2022/08/09/1_1db2488f17-anonymous.png",
            })
            socket = new WebSocket(socketUrl);

            socket.onopen = () => {
                console.log("connected!");
                store.commit("updateSocket", socket);
            }

            socket.onmessage = msg => {
                const data = JSON.parse(msg.data);
                if (data.event === "start-matching") {  // 匹配成功
                    store.commit("updateOpponent", {
                        username: data.opponent_username,
                        photo: data.opponent_photo,
                    });
                    setTimeout(() => {
                        store.commit("updateStatus", "playing");
                    }, 2000);
                    store.commit("updateGamemap", data.gamemap);
                }
            }

            socket.onclose = () => {
                console.log("disconnected!");
            }
        });

        onUnmounted(() => {
            socket.close();
            store.commit("updateStatus", "matching");
        })
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    }
}
</script>

<style scoped>
</style>
