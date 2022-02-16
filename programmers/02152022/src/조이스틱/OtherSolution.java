package 조이스틱;

public class OtherSolution {
    public int solution(String name) {
        int answer = 0;
        int offset;
        int move = name.length() - 1;   //  우측 방향으로 끝까지 이동

        for(int i = 0; i < name.length(); i++){
            char alphabet = name.charAt(i);
            answer += Math.min(
                    Math.abs(alphabet - 'A'),
                    1 + ('Z' - alphabet)
            );

            offset = i + 1;
            while (offset < name.length() && name.charAt(offset) == 'A') offset++;
            move = Math.min(
                    Math.min(
                            i * 2 + name.length() - offset, //  우측으로 이동 후 좌측으로 돌아서 이동
                            (name.length() - offset) * 2 + i    //  좌측으로 이동 후 우측으로 돌아서 이동
                    ),
                    move
            );
        }
        return answer + move;
    }
}
