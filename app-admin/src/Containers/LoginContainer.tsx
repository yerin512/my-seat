import styled from '@emotion/styled';

import { Button, TextField } from '@mui/material';

const Wrapper = styled.div({
  display: 'flex',
  justifyContent: 'center',
  alignContent: 'center',
  width: '100%',
  height: '100%',
  padding: '3rem 0',
});

const LoginForm = styled.form({
  display: 'block',
});

const LabelWrapper = styled.div({
  'div:not(:first-of-type)': {
    marginTop: ' 8px',
  },
});

const ButtonWrapper = styled.div({
  textAlign: 'center',
  marginTop: '1rem',
});

export default function LoginContainer() {
  return (
    <Wrapper>
      <LoginForm>
        <LabelWrapper>
          <div>
            <TextField
              id="outlined-basic" label="아이디" variant="outlined"/>
          </div>
          <div>
            <TextField
              id="outlined-basic"
              label="비밀번호"
              variant="outlined"
              type="password"
            />
          </div>
        </LabelWrapper>
        <ButtonWrapper>
          <Button type="submit" variant="outlined">로그인</Button>
        </ButtonWrapper>
      </LoginForm>
    </Wrapper>
  );
}
