<template>
    <div id="board-table">
        <div class="d-flex justify-content-center">
            <h1 class="">게시판</h1>
        </div>
        <hr>
        <table class="table table-bordered table-dark table-hover">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Writer</th>
                    <th>Content</th>
                    <th>Create_Time</th>
                    <th>Modify_Time</th>
                    <th class="text-center">
                        <router-link to="/createBoard" class="btn btn-outline-light btn-sm">글 쓰기</router-link>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(board, board_UID) in datas" v-bind:key="board_UID">
                    <td>{{board.board_UID}}</td>
                    <td>{{board.title}}</td>
                    <td>{{board.writer}}</td>
                    <td>{{board.content}}</td>
                    <td>{{board.create_TIME}}</td>
                    <td>{{board.modify_TIME}}</td>
                    <td>
                        <router-link class="btn btn-outline-light btn-sm" :to="{path: '/editBoard', query: {id: `${board.board_UID}`}}">
                            수정하기
                        </router-link>
                        <a class="btn btn-outline-light btn-sm" v-on:click="deleteBoard(`${board.board_UID}`)">삭제하기</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import axios from 'axios';

    export default ({
        name: 'boardTable',
        data () {
            return {
                datas: []
            }
        },
        created: function () {
                const URL = 'http://localhost:8080/board/searchBoard'
                axios.get(`${URL}`).then(result => {
                    this.datas = result.data
                })
        },
        methods: {
            deleteBoard: function (uid) {
                const URL = 'http://localhost:8080/board/deleteBoard'
                axios.delete(`${URL}`, 
                {
                    params: { uid: uid }
                })
                window.location.reload()
            }
        }
    })
</script>
 