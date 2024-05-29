// import { fetchInfScrollReplies } from "./getReply";

export function hideReply() {
  document.querySelector(".float-right").addEventListener("click", (e) => {
    e.preventDefault();
    document.getElementById('replyData').innerHTML = '';
  });
}
