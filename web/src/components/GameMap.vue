<template>
    <div ref="parent" class="gamemap">
        <canvas ref="canvas" tabindex="0"></canvas>
    </div>
</template>

<script>
import { GameMap } from "@/assets/scripts/GameMap";
import { ref, onMounted } from 'vue'
<<<<<<< HEAD
import { useStore } from 'vuex';

=======
import { useStore } from "vuex";
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529

export default {
    setup() {
        const store = useStore();
        let parent = ref(null);
        let canvas = ref(null);

        onMounted(() => {
<<<<<<< HEAD
            new GameMap(canvas.value.getContext('2d'), parent.value,store)
=======
            new GameMap(canvas.value.getContext('2d'), parent.value, store)
        
>>>>>>> 260afeb8ca2386dcc2576e9bfc82614b0417f529
        });

        return {
            parent,
            canvas
        }
    }
}
</script>

<style scoped>
div.gamemap {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>


