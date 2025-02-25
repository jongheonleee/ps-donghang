import Header from "componennts/Header";
import PostList from "componennts/PostList";
import Footer from "componennts/Footer";

export default function PostPage() {
    return (
        <>
            <Header />
            <PostList
                hasNavigation={ false }
            />
            <Footer />
        </>
    )
}
