<template>
    <div class="text-center">
        <h1>게시글 작성</h1>
        <hr>
        <div>
            <div class="d-flex flex-row justify-content-end">
                <h4 class="text-center me-auto pe-3">제목</h4>
                <input type="text" v-model="title" id="input_title">
            </div>
            <hr>
            <div class="d-flex flex-row justify-content-end">
                <h4 class="text-center  me-auto pe-3">작성자</h4>
                <input type="text" v-model="writer" id="input_writer">
            </div>
            <hr>
            <div class="d-flex flex-row justify-content-end">
                <h4 class="text-center  me-auto pe-3">내용</h4>
                <input type="text" v-model="content" id="input_content">
            </div>
        </div>
        <hr>
        <div class="d-flex flex-row justify-content-around">
            <button @click="createBoard" class="btn btn-outline-dark btn-lg">작성</button>
            <router-link to="/" class="btn btn-outline-dark btn-lg">취소</router-link>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import qs from 'qs';

    export default ({
        name: 'createBoard',
        data () {
            return {
                title: '',
                writer: '',
                content: ''
            }
        },
        methods: {
            createBoard: function () {
                const URL = 'http://localhost:8080/board/createBoard'
                axios.post(`${URL}`,
                qs.stringify({
                        TITLE: this.title,
                        WRITER: this.writer,
                        CONTENT: this.content
                }))
                window.location.href="/"
            }
        }
    })
</script>
