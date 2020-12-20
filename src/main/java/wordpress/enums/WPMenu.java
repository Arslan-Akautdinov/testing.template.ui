package wordpress.enums;

public enum WPMenu {
    POSTS;

    @Override
    public String toString() {
        return switch (this){
            case POSTS -> "menu-posts";
        };
    }
}
