package com.ehdgjs.board.web.board;

import java.util.List;

import com.ehdgjs.board.config.ApiResponse;
import com.ehdgjs.board.service.BoardService;
import com.ehdgjs.board.web.board.Dto.BoardCreateDto;
import com.ehdgjs.board.web.board.Dto.BoardDto;
import com.ehdgjs.board.web.board.Dto.BoardUpdateDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    
    private final BoardService boardService;

    //게시물 목록 조회
    @GetMapping("/searchBoard")
    public List<BoardDto> searchBoardList(){

        //전체 게시글 조회 boardList에 저장
        List<BoardDto> boardList = boardService.searchBoard();

        return boardList;
        
    }

    //게시물 등록
    @PostMapping("/createBoard")
    public ResponseEntity<?> createBoard(BoardCreateDto boardCreateDto){
        ApiResponse result = null;

        try{

            result = new ApiResponse(true, "성공", boardService.createBoard(boardCreateDto));
            return ResponseEntity.ok().body(result);

        }catch(Exception e){

            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);

        }
    }

    //게시물 수정
    @PatchMapping("/updateBoard")
    public ResponseEntity<?> updateBoard(BoardUpdateDto boardUpdateDto){
        ApiResponse result = null;

        try {

            result = new ApiResponse(true, "성공", boardService.updateBoard(boardUpdateDto));
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);

        }
    }

    //게시물 삭제
    @DeleteMapping("/deleteBoard")
    public ResponseEntity<?> deleteBoard(Long board_uid){
        ApiResponse result = null;

        try {

            result = new ApiResponse(true, "성공", boardService.deleteBoard(board_uid));
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {

            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);

        }
    }
}
