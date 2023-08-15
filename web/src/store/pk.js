<<<<<<< HEAD
export default {
    state:{
        status :"matching",//matching和playing
        socket :null,
        opponent_username: "",
        opponent_photo:"",
        gamemap:null,

=======


export default{
    state:{
        status:"matching",//matching是匹配界面,playing是对战界面
        socket:null,
        opponent_username:"",
        opponent_photo:"",
        gamemap:null,
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    },
    getters:{
    },
    mutations:{
<<<<<<< HEAD
        updateSocket(state,socket){
            state.socket = socket;
        },
        updateOpponent(state,opponent){
            state.opponent_username = opponent.username;
            state.opponent_photo = opponent.photo;
        },
        updateStatus(state,status){
            state.status = status;
        },
        updateGamemap(state,gamemap){
            state.gamemap=gamemap;
        }
=======
        updateSocket(state, socket) {
            state.socket = socket;
        },
        updateOpponent(state, opponent) {
            state.opponent_username = opponent.username;
            state.opponent_photo = opponent.photo;
        },
        updateStatus(state, status) {
            state.status = status;
        },
        updateGamemap(state, gamemap) {
            state.gamemap = gamemap;
        }

>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
    },
    actions:{
    },
    modules:{
    }
}