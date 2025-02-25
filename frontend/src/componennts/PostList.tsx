import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import axios, {AxiosResponse} from 'axios';


// 전달받는 props 매개변수 인터페이스로 정의
// 타입스크립트의 최대 장점 -> 타입 안정성 확보(컴파일시 타입 시스템으로 타입 정보 검사)
interface PostListProps {
    hasNavigation?: boolean;
}

// 탭 타입 정의
// 전체, 나의 글 유형으로 존재함
type TabType = "all" | "my";

// 게시글 인터페이스 정의
interface Post {
    id: number;
    title: string;
    content: string;
    createdBy: string;
    createdAt: string;
}

// 게시글 목록 인터페이스 정의
interface PostResponse {
    content: Post[]; // "content" 필드가 배열을 포함하고 있다고 명시
}

export default function PostList({ hasNavigation = true } : PostListProps) {
    const [activeTab, setActiveTab] = useState<TabType>("all");
    const [posts, setPosts] = useState<Post[]>([]);

    useEffect(() => {
        const fetchPosts = async () => {
            try {
                const response: AxiosResponse<PostResponse> = await axios.get("http://localhost:8080/posts", {
                    headers: {
                        "Content-Type": "application/json",
                    },
                });

                console.log("Response from backend:", response);
                setPosts(response.data.content);
            } catch (error) {
                console.error("Error fetching posts:", error);
            }
        };

        fetchPosts(); // 컴포넌트 마운트 시 실행
    }, []);

    return (
        <>
            {/* 네비게이션 영역 - 네비게이션의 경우 리스트에선 보여야 하지만, 프로필 페이지에선 보이면 안됨 */}
            {hasNavigation && (
                <div className="post__navigation">
                    <div
                        role="presentation"
                        onClick={() => setActiveTab("all")}
                        className={activeTab === "all" ? "post__navigation--active" : ""}
                    >
                        전체
                    </div>
                    <div
                        role="presentation"
                        onClick={() => setActiveTab("my")}
                        className={activeTab === "my" ? "post__navigation--active" : ""}
                    >
                        나의 글
                    </div>
                </div>
            )}

            {/* 블로그 글 리스트 영역 */}
            <div className="post__list">
                {[...posts].map((post) => (
                    <div key={ post.id } className="post__box">
                        <Link to={`/posts/${post.id}`}>
                            {/* 상단 프로필 박스 */}
                            <div className="post__profile-box">
                                <div className="post__profile" />
                                <div className="post__author-name"> {post.createdBy} </div>
                                <div className="post__date">{post.createdAt}</div>
                            </div>

                            {/* 게시글 제목 */}
                            <div className="post__title">{post.title}</div>

                            {/* 텍스트 영역 */}
                            <div className="post__text">
                                post.content
                            </div>

                            {/* 수정/삭제 버튼 영역 */}
                            <div className="post__utils-box">
                                <div className="post__delete">삭제</div>
                                <div className="post__edit">수정</div>
                            </div>
                        </Link>
                    </div>
                ))}
            </div>
        </>
    )
}
