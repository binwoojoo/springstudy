
const BASE_URL = 'http://localhost:8383/board/detail?bno=${}';

const $reaction = document.querySelector('.reaction');

$reaction.addEventListener('click', e => {
    if(e.target.matches('#like-btn')) {
        console.log('좋아요!!!!');
    } else if(e.target.matches('#dislike-btn')) {
        console.log('싫어요!!!!');
    } 
});
