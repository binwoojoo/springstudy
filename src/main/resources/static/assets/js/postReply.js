import { BASE_URL } from "./reply.js";
// import { renderReplies } from "./getReply.js";
import { fetchInfScrollReplies } from "./getReply.js";

// 서버에 댓글 등록을 요청하는 비동기 함수
export const fetchReplyPost = async () => {
  const textInput = document.getElementById("newReplyText");
  const writerInput = document.getElementById("newReplyWriter");

  const payload = {
    text: textInput.value,
    author: writerInput.value,
    bno: document.getElementById("wrap").dataset.bno,
  };

  const res = await fetch(`${BASE_URL}`, {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(payload),
  });

  const replies = await res.json();

  //   console.log(replies);
  // renderReplies(replies);
  fetchInfScrollReplies();
  window.scrollTo(0, 0);
};
