import {Link} from "react-router-dom";

export default function PostDetail() {
    return (
        <>
            <div className="post__detail">
                <div className="post__box">
                        {/* 게시글 제목 */}
                        <div className="post__title">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        </div>

                        {/* 프로필 영역 */}
                        <div className="post__profile-box">
                            <div className="post__profile" />
                            <div className="post__author-name"> yeonuel </div>
                            <div className="post__date">2025.02.25 화요일</div>
                        </div>

                        {/* 수정/삭제 버튼 영역 */}
                        <div className="post__utils-box">
                            <div className="post__delete">삭제</div>
                            <div className="post__edit">
                                <Link to={`/posts/edit/1`}> 수정 </Link>
                            </div>
                        </div>

                        {/* 텍스트 영역 */}
                        <div className="post__text">
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                            Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                            when an unknown printer took a galley of type and scrambled it to make a type specimen book.
                            It has survived not only five centuries, but also the leap into electronic typesetting,
                            remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
                            and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                        </div>
                </div>
            </div>
        </>
    )
}
