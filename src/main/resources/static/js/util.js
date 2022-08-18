let isNull = (original) => {
    if(!original) return true;
    if(typeof(original) === 'string'){
        return original === "" || original === 'undefined' || original === null;
    }else if(['number'].indexOf(typeof(original) > -1)){
        return false;
    }else{
        throw new Error("정의되지않은 형식입니다");
    }
}

let nullIf = (original,basic) => {
    if(isNull(original)){
        if(isNull(basic)){
            return basic;
        }
    }
    return original
}

let lastCharMerge = (target,char) => {
    if(isNull(target)) return target;
    target = target.substr(-1) === char ? target : (target + char);
    return target;
}

export {isNull,nullIf,lastCharMerge}