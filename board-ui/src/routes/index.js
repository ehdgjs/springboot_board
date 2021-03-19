import Vue from 'vue';
import VueRouter from 'vue-router';
import EditBoard from '../components/editBoard.vue'
import BoardTable from '../components/boardTable.vue'

Vue.use(VueRouter);
export const router = new VueRouter({
    mode: 'history',
    routes:[
        {
            path: '/',
            component: BoardTable
        },
        {
            path: '/editBoard',
            component: EditBoard
        }
    ]
})